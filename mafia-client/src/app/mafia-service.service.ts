import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GameSession } from './gamesession.model';
import { PlayerRequest } from './player-request.model';

@Injectable({
  providedIn: 'root'
})
export class MafiaServiceService {
  private createGameUrl : string = 'http://localhost:7005/api/mafiaGame';
  private gameSession : GameSession;

  constructor(private http: HttpClient) { }

  createGame(playerName: PlayerRequest) {
    let header = new HttpHeaders({'Content-Type': 'application/json'});
    this.http.post(this.createGameUrl,JSON.stringify({playerName}),{headers : header})
      .subscribe((response) => {
        console.log(response);
        return response;
      });

  }

}
