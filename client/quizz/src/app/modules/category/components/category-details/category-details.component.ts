import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/interface/category';
import { CategoryService } from '../../services/category.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})
export class CategoryDetailsComponent implements OnInit {
  category$!: Observable<Category>;

  constructor(private categoryService: CategoryService, private route: ActivatedRoute){}

  ngOnInit(): void {
    this.getCategoryQuizzes();
  }

  getCategoryQuizzes() {
    const categoryId = this.route.snapshot.paramMap.get('id');
      if(categoryId != null){
        this.category$ = this.categoryService.fetchCategory(+categoryId);
      }
  }
}
