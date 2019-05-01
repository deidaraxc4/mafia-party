import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GameSession } from './gamesession.model';
import { PlayerRequest } from './player-request.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MafiaServiceService {
  private createGameUrl : string = 'http://localhost:7005/api/mafiaGame';
  private getGameUrl : string = "http://localhost:7005/api/gameSession/"
  private gameSession : GameSession;

  constructor(private http: HttpClient) { }

  createGame(playerName: PlayerRequest) : Observable<GameSession> {
    let header = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post<GameSession>(this.createGameUrl,JSON.stringify({playerName}),{headers : header})
      // .subscribe((response) => {
      //   console.log(response);
      //   return response;
      // });

  }

  getGame(gameSessionId: number) : Observable<GameSession> {
    return this.http.get<GameSession>(this.getGameUrl+gameSessionId)
      // .subscribe((response: GameSession) => {
      //   console.log(response);
      //   this.gameSession = response;
      // });
  }

}
