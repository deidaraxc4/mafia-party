import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-role-card',
  templateUrl: './role-card.component.html',
  styleUrls: ['./role-card.component.css']
})
export class RoleCardComponent implements OnInit {
  roleName : string;
  alignment : string;
  description : string;
  imgUrl : string;

  constructor() { }

  ngOnInit() {
  }

}
