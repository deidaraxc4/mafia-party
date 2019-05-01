import { Player } from "./player.model";

export class GameSession {
    gameSessionId : number;
    gameState : string;
    playerCount : number;
    players : Player[];
}