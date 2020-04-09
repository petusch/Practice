import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { User } from "./user";

@Injectable()
export class HttpService {
  constructor(private http: HttpClient) {}

  postData(user: User) {
    const body = { name: user.name, surname: user.surname, email: user.email, birthDate: user.birthdate, password: user.password };
    return this.http.post("http://localhost:8080/testUser", body);
  }
}
