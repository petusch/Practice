import { Component } from "@angular/core";
import { HttpService } from "./http.service";
import { User } from "./user";

@Component({
  selector: "my-app",
  templateUrl: `app.html`,
  styleUrls: [`app.css`]
})
export class AppComponent {
  user: User = new User();
  receivedUser: User;
  done: boolean = false;
  validated: boolean = true;
  constructor(private httpService: HttpService) {}
  submit(user: User) {
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
