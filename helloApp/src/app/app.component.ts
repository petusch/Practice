import { Component } from "@angular/core";
import { HttpService } from "./http.service";
import { User } from "./user";
import { FormControl, Validators } from "@angular/forms";

@Component({
  selector: "my-app",
  templateUrl: `app.html`,
  styleUrls: [`app.css`]
})
export class AppComponent {
  user: User = new User();
  receivedUser: User;
  done: boolean = false;
  
  constructor(private httpService: HttpService) {}
  submit(user: User) {
    if(this.validate(user))
    {
    this.httpService.postData(user).subscribe(
      (data: User) => {
        this.receivedUser = data;

        // console.log(this.receivedUser);
        // this.receivedUser.birthdate = new Date();
        // this.receivedUser.birthdate.setDate(this.receivedUser.birthdate.getDate() + 1);
        // this.receivedUser.birthdate.setHours(0,0,0,0);
        // console.log(this.receivedUser);

        this.done = true;
      },
      error => console.log(error)
    );
    }
  }

  validate(user: User){
    if(new FormControl(user.name, Validators.minLength(3))!=null ||
    new FormControl(user.surname, Validators.minLength(3))!=null ||
    new FormControl(user.email,Validators.email)!=null ||
    new FormControl(user.password,Validators.minLength(6)) ||
    new FormControl(user.birthdate,Validators.required))
    return false;
    else return true
  }
}
