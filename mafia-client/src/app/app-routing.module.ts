import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component'
import { AboutComponent } from './about/about.component';
import { JoinGameComponent } from './join-game/join-game.component';
import { CreateGameComponent } from './create-game/create-game.component';
import { NarratorScreenComponent } from './narrator-screen/narrator-screen.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch:'full'},
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'join', component: JoinGameComponent },
  { path: 'create', component: CreateGameComponent },
  { path: 'narrator-screen', component: NarratorScreenComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }