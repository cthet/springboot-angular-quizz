import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageCategoryComponent } from './components/page-category/page-category.component';
import { CategoryDetailsComponent } from './components/category-details/category-details.component';

const routes: Routes = [
  {
    path: '',
    component: PageCategoryComponent,
  },
  {
    path: ':id',
    component: CategoryDetailsComponent,
  },
  {
    path: 'quiz/:id',
    loadChildren: () => import('../quiz/quiz.module').then((m) => m.QuizModule)    
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryRoutingModule { }
