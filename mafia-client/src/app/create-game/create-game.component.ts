import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PlayerRequest } from '../player-request.model';
import { Router } from '@angular/router';
import { GameSession } from '../gamesession.model';
import { MafiaServiceService } from '../mafia-service.service';

@Component({
  selector: 'app-create-game',
  templateUrl: './create-game.component.html',
  styleUrls: ['./create-game.component.css']
})
export class CreateGameComponent implements OnInit {
  private createGameUrl : string = 'http://localhost:7005/api/mafiaGame';

  constructor(private http: HttpClient, private route: Router, private mafiaService: MafiaServiceService) { }

  ngOnInit() {
  }

  createGame(playerName: PlayerRequest) {
    console.log(JSON.stringify(playerName));
    let header = new HttpHeaders({'Content-Type': 'application/json'});
    this.mafiaService.createGame(playerName);
    // this.http.post<GameSession>(this.createGameUrl,JSON.stringify({playerName}),{headers :header})
    //   .subscribe((response) => {
    //     console.log(response);
    //     this.route.navigate(['/narrator-screen']);
    //     // we have to pass response into the narrator component to display the info
    //   })
  }

}
