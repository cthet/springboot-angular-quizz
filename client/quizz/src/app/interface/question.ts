import { Answer } from "./answer";
import { Choice } from "./choice";

export interface Question{
  id: number;
  content: string;
  url?: string;
  choices: Choice[];
  answers: Answer[];
}