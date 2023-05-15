import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QuizRoutingModule } from './quiz-routing.module';
import { PageQuestionComponent } from './components/page-question/page-question.component';
import { PageResultsComponent } from './components/page-results/page-results.component';
import { PageQuizComponent } from './components/page-quiz/page-quiz.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    PageQuestionComponent,
    PageQuizComponent,
    PageResultsComponent
  ],
  imports: [
    CommonModule,
    QuizRoutingModule,
    ReactiveFormsModule
  ]
})
export class QuizModule { }
