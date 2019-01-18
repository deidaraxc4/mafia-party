import { Component, OnInit, Input } from '@angular/core';
import { RoleCard } from './role-card.model';

@Component({
  selector: 'app-role-card',
  templateUrl: './role-card.component.html',
  styleUrls: ['./role-card.component.css']
})
export class RoleCardComponent implements OnInit {
  @Input('roleCard') roleCard : RoleCard;

  constructor() { }

  ngOnInit() {
  }

}
