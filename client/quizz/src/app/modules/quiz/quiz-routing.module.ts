import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PageQuizComponent } from './components/page-quiz/page-quiz.component';


const routes: Routes = [
  {
    path: '',
    component: PageQuizComponent,
 },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QuizRoutingModule { }
