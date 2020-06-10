import { Component, OnInit } from '@angular/core';
import { CenterService } from '../center.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-center',
  templateUrl: './add-center.component.html',
  styleUrls: ['./add-center.component.css']
})
export class AddCenterComponent implements OnInit {

  success: string;
  failure: string;

  constructor(private center: CenterService) { }

  ngOnInit(): void {
  }

  addCenter(form: NgForm) {
    this.center.addCenter(form.value).subscribe(data => {
      console.log(data);

      if (data.statusCode === 201) {
        this.success = data.description;
        setTimeout(() => {
          this.success = null;
        }, 3000);
        form.reset();
      } else {
        this.failure = data.description;
        setTimeout(() => {
          this.failure = null;
        }, 3000);
      }
    });
  }

}
