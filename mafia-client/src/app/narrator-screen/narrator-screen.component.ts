import { Component, OnInit, Input } from '@angular/core';
import { GameSession } from '../gamesession.model';
import { MafiaServiceService } from '../mafia-service.service';

@Component({
  selector: 'app-narrator-screen',
  templateUrl: './narrator-screen.component.html',
  styleUrls: ['./narrator-screen.component.css']
})
export class NarratorScreenComponent implements OnInit {
  @Input('gamesession') gameSession : GameSession;

  constructor(private mafiaService : MafiaServiceService) { }

  ngOnInit() {
  }

  getGame() {
    this.mafiaService.getGame(1)
        .subscribe((response: GameSession) => {
        console.log(response);
        this.gameSession = response;
      });
  }

}
