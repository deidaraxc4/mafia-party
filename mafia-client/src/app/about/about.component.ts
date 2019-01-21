import { Component, OnInit } from '@angular/core';
import { RoleCard } from '../role-card/role-card.model';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent implements OnInit {
  roleCardArray : RoleCard[];

  constructor() { 

  }

  ngOnInit() {
    this.roleCardArray = [
      {
        roleName:"Sherrif",
        alignment:"Town - Investigative",
        description:"You are the law enforcement of the town. Interrogate one person each night to reveal if they are suspicious or not.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Sheriff.png"
      },
      {
        roleName:"Lookout",
        alignment:"Town - Investigative",
        description:"You keep watch at night. Stake out one person's house and see who visits them that night.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Lookout.png"
      },
      {
        roleName:"Vigilante",
        alignment:"Town - Killing",
        description:"You take matters into your own hands. You have one bullet throughout the game and can shoot someone at night.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Vigilante.png"
      },
      {
        roleName:"Veteran",
        alignment:"Town - Killing",
        description:"You are an old war hero of this town. You can choose to go on alert at night 3 times throughout the game, kill anyone that visits your house that night.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Veteran.png"
      },
      {
        roleName:"Doctor",
        alignment:"Town - Protective",
        description:"You are the doctor of the town. Heal one person each night, cannot heal the same person twice in a row.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Doctor.png"
      },
      {
        roleName:"BodyGuard",
        alignment:"Town - Protective",
        description:"You make a living protecting others. You can guard someone each night, if they were to die you would die in place and kill their attacker.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Bodyguard.png"
      },
      {
        roleName:"Mayor",
        alignment:"Town - Support",
        description:"You are the leader of the town. You can choose to reveal yourself as the mayor during the day any time of the game.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Mayor.png"
      },
      {
        roleName:"Escort",
        alignment:"Town - Support",
        description:"You are an exotic dancer. You can choose to escort someone each night to prevent them from using their ability.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Escort.png"
      },
      {
        roleName:"Retributionist",
        alignment:"Town - Support",
        description:"You deal with the dark arts. You can revive one dead person throughout the game.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Retributionist.png"
      },
      {
        roleName:"Transporter",
        alignment:"Town - Support",
        description:"You are a scientist with a transporter machine. You can swap the locations of two people during the night, and all effects on them will be redirected to each other.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Transporter.png"
      },
      {
        roleName:"Godfather",
        alignment:"Mafia - Killing",
        description:"You are the leader of the mafia. You cannot be killed at night, choose one target for the mafia to kill at night.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Godfather.png"
      },
      {
        roleName:"Mafioso",
        alignment:"Mafia - Killing",
        description:"You recently joined the ranks of the mafia. You follow the orders of the Godfather and kill someone each night.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Mafioso.png"
      },
      {
        roleName:"Framer",
        alignment:"Mafia - Deception",
        description:"You are skilled in forging evidence. You can frame someone each night to make them appear suspicious.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Framer.png"
      },
      {
        roleName:"Blackmailer",
        alignment:"Mafia - Support",
        description:"You have the dirt on everyone in this town. Blackmail someone each night to prevent them from talking the next day.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Blackmailer.png"
      },
      {
        roleName:"Consort",
        alignment:"Mafia - Support",
        description:"You are the second most exotic dancer in town. Distract someone each night by visiting their house and blocking their ability.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Consort.png"
      },
      {
        roleName:"Survivor",
        alignment:"Neutral - Benign",
        description:"You are a recluse. Your goal is to survive until the end of the game. You can hide in your shelter 3 times throughout the game to protect yourself.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Survivor.png"
      },
      {
        roleName:"Jester",
        alignment:"Neutral - Evil",
        description:"You are a maniac and want to get lynched. Your goal is to trick the town into lynching you.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Jester.png"
      },
      {
        roleName:"Executioner",
        alignment:"Neutral - Evil",
        description:"You hold a strong grudge against someone in the town. Your goal is to get that person lynched.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/Executioner.png"
      },
      {
        roleName:"Serial Killer",
        alignment:"Neutral - Killer",
        description:"You enjoy killing. Your goal is to kill everyone in the town and you cannot be killed at night.",
        imgUrl:"https://www.blankmediagames.com/wp-content/themes/townofsalem/assets/img/roles/SerialKiller.png"
      },

    ]
  }


}
