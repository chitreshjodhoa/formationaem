import { Component, Input, OnInit } from '@angular/core';
import {MapTo} from '@adobe/cq-angular-editable-components';

interface Transport {
    name: string;
    address: string;
    dept: string;
    type: string;
}

const CustomEditConfig = {
  emptyLabel: 'Transport List',
  isEmpty: cqModel =>
    !cqModel || !cqModel.transportList
};

@Component({
  selector: 'app-custom',
  templateUrl: './transport-list.component.html',
  styleUrls: ['./transport-list.component.css']
})
export class TransportListComponent implements OnInit {

  @Input() transportList: Transport[];

  constructor() { }

  ngOnInit(): void {
  }

}

MapTo('wknd-spa-angular/components/transport-list')(TransportListComponent, CustomEditConfig);
