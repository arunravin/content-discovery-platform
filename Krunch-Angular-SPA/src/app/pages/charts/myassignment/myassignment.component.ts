import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'ngx-myassignment',
  templateUrl: './myassignment.component.html',
  styleUrls: ['./myassignment.component.scss']
})
export class MyassignmentComponent implements OnInit {

  selectedValue: Date;
  min: Date;
  max: Date;
  
  constructor() { }

  ngOnInit(): void {
  }

}
