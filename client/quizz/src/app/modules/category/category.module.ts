import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CategoryRoutingModule } from './category-routing.module';
import { CategoryDetailsComponent } from './components/category-details/category-details.component';
import { PageCategoryComponent } from './components/page-category/page-category.component';


@NgModule({
  declarations: [
    PageCategoryComponent,
    CategoryDetailsComponent,
  ],
  imports: [
    CommonModule,
    CategoryRoutingModule
  ]
})
export class CategoryModule { }
