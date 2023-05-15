import { Quiz } from './quiz';

export interface Category {
  id: number;
  name: string;
  quizzes: Quiz[];
}