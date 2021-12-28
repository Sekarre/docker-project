import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {FibonacciResponse} from "../domain/FibonacciResponse";
import {FibonacciHistory} from "../domain/FibonacciHistory";

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  calculateURL = "http://localhost:8080/api/fibonacci?n=";
  calculateHistoryURL = "http://localhost:8080/api/fibonacci-history";
  calculatorFormGroup: FormGroup;

  fibonacciResponse: FibonacciResponse;
  fibonacciResponseHistory: FibonacciHistory[];

  constructor(private formBuilder: FormBuilder,
              private http: HttpClient) {
  }

  ngOnInit(): void {
    this.calculatorFormGroup = this.formBuilder.group({
      nValue: new FormControl('',
        [Validators.required, Validators.minLength(1), Validators.min(0), Validators.pattern("^[0-9]*$"),]),
    });
    this.getFibonacciCalculationHistory();
  }

  calculateValue() {
    const url = this.calculateURL + this.calculatorFormGroup.get('nValue').value;

    if (this.calculatorFormGroup.valid) {
      this.http.get<FibonacciResponse>(url).subscribe(
        data => {
          this.fibonacciResponse = data;
          this.getFibonacciCalculationHistory();
        },
        () => alert('Wops, error occurred'))
    }
  }

  getFibonacciCalculationHistory() {
    this.http.get<FibonacciHistory[]>(this.calculateHistoryURL).subscribe(
      data => this.fibonacciResponseHistory = data);
  }
}
