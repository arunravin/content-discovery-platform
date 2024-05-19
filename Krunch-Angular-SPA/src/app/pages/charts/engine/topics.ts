export class topics{

    topicName: string;
    topicSubType: string;
    checked: boolean

    constructor(topicName: string , topicSubType: string , checked: boolean)   {
        this.topicName = topicName;
        this.topicSubType = topicSubType;
        this.checked=checked;
      }

}