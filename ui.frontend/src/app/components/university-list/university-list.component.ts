import { Component, Input, OnInit } from '@angular/core';
import {MapTo} from '@adobe/cq-angular-editable-components';

interface University {
    domains: string[];
    state_province: string;
    country: string;
    alpha_two_code: string;
    web_pages: string[];
    name: string;
}

const CustomEditConfig = {
  emptyLabel: 'University List',
  isEmpty: cqModel =>
    !cqModel || !cqModel.country
};

@Component({
  selector: 'app-custom',
  templateUrl: './university-list.component.html',
  styleUrls: ['./university-list.component.css']
})
export class UniversityListComponent implements OnInit {

  @Input() country: University[];

  constructor() { }

  ngOnInit(): void {
  }

}

MapTo('wknd-spa-angular/components/university-list')(UniversityListComponent, CustomEditConfig);
