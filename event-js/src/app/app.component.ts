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
    this.httpService.postData(user).subscribe(
      (data: User) => {
        this.receivedUser = data;

        this.done = true;
      },
      error => console.log(error)
    );
    }
  }

