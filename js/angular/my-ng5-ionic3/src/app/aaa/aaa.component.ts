import {Component, OnInit} from "@angular/core";

@Component({
  ///selector: '[aaa-component]',
  templateUrl: './aaa.component.html',
  styleUrls: ['./aaa.component.scss']
})
export class AaaComponent implements OnInit {
  v = 'a1-a2';

  /**
   * 因为使用了 CustomReuseStrategy，所以，该状态得以保存，
   * 但是 /bbb 下面是异步加载的独立模块。所以 /bbb 中的数值没有保存
   * @type {number}
   */
  n: number = 0;

  constructor() {
  }

  ngOnInit(): void {

  }

  changeNum(): void {
    this.n++;
  }
}
