import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Category } from 'src/app/interface/category';


const categoriesUrl = `http://localhost:8080/api/v1/categories`;
const categoryUrl = `http://localhost:8080/api/v1/category`;

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  fetchCategories(): Observable<Category[]>{
    return this.http.get<Category[]>(categoriesUrl).pipe(catchError(this.handleError));
  }

  fetchCategory(categoryId: number): Observable<Category>{
    return this.http.get<Category>(`${categoryUrl}/${categoryId}`).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      //a client-side or network error occured. Handle it accordingly.
      console.log('An error occured:', error.error);
      return throwError(() => error.message);
    } else {
      // the backend returned an unsuccesful response code.
      // the response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was:`,
        error.error
      );
      return throwError(() => new Error(error.message));
    }
  }
}
