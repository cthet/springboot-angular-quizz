import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { QuizRoutingModule } from './quiz-routing.module';

import { PageQuizComponent } from './components/page-quiz/page-quiz.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    PageQuizComponent,
  ],
  imports: [
    CommonModule,
    QuizRoutingModule,
    ReactiveFormsModule
  ]
})
export class QuizModule { }
