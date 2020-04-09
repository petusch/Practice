package com.example.resthelloworld.services.impl;

import com.example.resthelloworld.entity.User;
import com.example.resthelloworld.services.UserService;
import com.github.jasync.sql.db.Connection;
import com.github.jasync.sql.db.QueryResult;
import com.github.jasync.sql.db.RowData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.example.resthelloworld.services.impl.FormingRequest.formingRequest;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Connection connection;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<User> registerNewAccount(User tempUser) {
        if (emailExist(tempUser.getEmail())) {

            return new ResponseEntity<>(new User(),HttpStatus.EXPECTATION_FAILED);
        }

        tempUser.setPassword(passwordEncoder.encode(tempUser.getPassword()));
        User user = tempUser;
        System.out.println(tempUser.getUserCreation());
        System.out.println(tempUser.getBirthDate());
        addUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public List<User> read(Map<String, String> requestParams) {
        String request = formingRequest(requestParams, "read","users");
        CompletableFuture<List<User>> future = connection.sendPreparedStatement(request)
                .thenApply(result -> result.getRows()
                        .stream()
                        .map((RowData rowData) -> new User(rowData.getString("name"),
                                rowData.getString("surname"),
                                rowData.getString("email")))
                        .collect(Collectors.toList())
                );
        List<User> list = future.join();
        for(User user : list)
        {
            System.out.println(user.toString());
        }
        return list;
    }

    @Override
    public List<User> readAll() {
        CompletableFuture<List<User>>future = connection.sendPreparedStatement("select * from users")
                .thenApply(result -> result.getRows()
                        .stream()
                        .map((RowData rowData) -> new User(rowData.getString("name"),
                                rowData.getString("surname"),
                                rowData.getString("email"),
                                rowData.getDate("birthdate"),
                                rowData.getDate("creationdate")))
                        .collect(Collectors.toList())
                );

        return future.join();
    }

    @Override
    public User addUser(User user) {
                CompletableFuture<QueryResult> future = connection.sendPreparedStatement("INSERT INTO public.users(\n" +
                "\t name, surname, birthdate, creationDate, eMail, password)\n" +
                "\tVALUES ( \' "+user.getName()+"\' , \'"+user.getSurname()+"\' , \'"+user.getBirthDate()+ "\' , \'"+ user.getUserCreation() +"\' , \'"+user.getEmail()+"\' , \'"+ user.getPassword()+"\');");

        return user;
    }

    @Override
    public void deleteById(Map<String, String> requestParams) {

        String request = formingRequest(requestParams, "delete","users");

        connection.sendPreparedStatement(request);
    }

    @Override
    public User update(String request) {
        return null;
    }

    private boolean emailExist(String email)
    {
        List<User> list = readAll();

        for (User u:
             list) {
            if(u.getEmail().trim().equalsIgnoreCase(email.trim()))
                return true;
        }
        return false;
    }
}
