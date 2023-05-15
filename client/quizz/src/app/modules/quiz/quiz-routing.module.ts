import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageQuestionComponent } from './components/page-question/page-question.component';
import { PageQuizComponent } from './components/page-quiz/page-quiz.component';
import { PageResultsComponent } from './components/page-results/page-results.component';

const routes: Routes = [
  {
    path: '',
    component: PageQuizComponent,
  //   children: [
  //    {
  //      path: 'question/:id',
  //      component: PageQuestionComponent,
  //    },
  //    {
  //      path: 'results',
  //      component: PageResultsComponent,    
  //    },  
  //  ]
 }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QuizRoutingModule { }
