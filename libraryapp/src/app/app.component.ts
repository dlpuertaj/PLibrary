import { Component, OnInit } from '@angular/core';
import { Book } from './book';
import { BookService } from './book.service';
import { HttpErrorResponse} from '@angular/common/http';
import { NgForm } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'libraryapp';
  books: Book[] = [];

  constructor(private bookService: BookService){}

  ngOnInit(){
  	this.getBooks();
  }

  public getBooks(): void{
  	this.bookService.getBooks().subscribe(
		(response: Book[]) => {
			this.books = response;
		},
		(error: HttpErrorResponse) => {
			alert(error.message);
		}
	);
  }
}
