import { topics } from './topics';
import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {COMMA, ENTER} from '@angular/cdk/keycodes';
import {MatChipInputEvent} from '@angular/material/chips';

export interface Topic {
  name: string;
}

@Component({
  selector: 'ngx-engine',
  templateUrl: './engine.component.html',
  styleUrls: ['./engine.component.scss']
})
export class EngineComponent implements OnInit {

  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;

  selectedValue: Date;
  engineName: string;
  engineDescription: string;

  selectedTopics: any;
  selectedPersonas: any;
  selectedNotifications: any;

  sourceTopics: topics[];
  sourceTopics1: topics[];
  sourceTopics2: topics[];
  targetTopics: topics[];

  min: Date;
  max: Date; 

  //toppings = new FormControl();

  personaTypes: string[] = ['Research Analyst', 'Cloud Native Engineer', 'Architect','Data Scientist',
  'CEO','Chief Digital Officer'];

  topicsList: string[] = ['Technology', 'Domain', 'Disruptive Innovation',];

  notificationsList: string[] = ['Real Time Alerts', 'Daily Digest', 'Weekly Digest',];
/*
    trackTopics: Agritech,angular,ArtificialIntelligence,api,aws,AutoMl,#azure,bigdata,
    #bitcoin,c3.ai,CloudFlare,CloudNative,cybersecurity,DataDog,datalake,datascience,
    deeplearning,devops,devsecops,docusign,
    cryptocurrency,Decentralized,docker,edgecomputing,
    EdTech,Fastly,fintech,fullstack,futureofwork,Gartner,
    graphdb,gcp,healthtech,
    kubernetes,
    machinelearning,microservice,MultiCloud,Neo4j,openshift,OutSystems
    #,opensource,#programming,reactjs,regtech,remotecollaboration
    shiptech,springboot,,,,,,,#,,
    ,#sre,#ServiceNow,#SnowFlake,#YellowBrick,QuantumComputing,telemedicine
    #wealthtech
    **/

  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  topics1: Topic[] = [
    {name: 'Agritech'}, {name: 'AI'},{name: 'Angular'},
    {name: 'API'},{name: 'AutoML'},{name: 'AWS'},{name: 'Azure'}, {name: 'BigData'},{name: 'Bitcoin'},
    {name: 'C3.AI'},{name: 'CloudFlare'},  {name: 'CloudNative'},{name: 'CyberSecurity'}, {name: 'DataDog'}, 
    {name: 'DataLake'}, {name: 'DataScience'}, {name: 'DeepLearning'},{name: 'DevOps'},
    {name: 'DevSecOps'}, {name: 'Docusign'}, {name: 'CryptoCurrency'},{name: 'Docker'},
    {name: 'EdgeComputing'}, {name: 'EdTech'}, {name: 'Fastly'},{name: 'Fintech'},
    {name: 'Fullstack'}, {name: 'FutureOfWork'}, {name: 'Gartner'},{name: 'Graphdb'},
    {name: 'GCP'}, {name: 'HealthTech'}, {name: 'Kubernetes'},{name: 'MachineLearning'},
    {name: 'Microservice'}, {name: 'Multicloud'}, {name: 'Neo4J'},{name: 'Openshift'},
    {name: 'OutSystems'}, {name: 'OpenSource'}, {name: 'Programming'},{name: 'ReactJs'},
    {name: 'Regtech'}, {name: 'RemoteCollaboration'}, {name: 'Shiptech'},{name: 'Springboot'},
    {name: 'SRE'}, {name: 'ServiceNow'}, {name: 'Snowflake'},{name: 'QuantumComputing'},
      {name: 'Telemedicine'}, {name: 'YellowBrick'}, {name: 'Wealthtech'} ];

  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;

    // Add our fruit
    if ((value || '').trim()) {
      this.topics1.push({name: value.trim()});
    }

    // Reset the input value
    if (input) {
      input.value = '';
    }
  }

  remove(topic: Topic): void {
    const index = this.topics1.indexOf(topic);

    if (index >= 0) {
      this.topics1.splice(index, 1);
    }
  }
  

  constructor() { 

    

this.sourceTopics=[new topics("AgriTech","Technology",true),new topics("Angular","Technology",true),
      new topics("AI","Technology",true),new topics("API","Technology",true),
      new topics("AutoML","Technology",true),new topics("AWS","Technology",true),
      new topics("Azure","Technology",true),new topics("BigData","Technology",true),
      new topics("BitCoin","Disruptive Innovation",true),new topics("C3.AI","Disruptive Innovation",true),
      new topics("CloudFlare","Technology",true),new topics("CloudNative","Technology",true),
      new topics("CloudComputing","Technology",true),
      new topics("CyberSecurity","Technology",true),new topics("CryptoCurrency","Technology",true),
      new topics("DataDog","Technology",true),new topics("DataLake","Technology",true)];

this.sourceTopics1=[      
      new topics("DataScience","Technology",true),
      new topics("DeepLearning","Technology",true),new topics("DevOps","Technology",true),
      new topics("DevSecOps","Disruptive Innovation",true),new topics("DocuSign","Disruptive Innovation",true),
      new topics("Docker","Technology",true),new topics("EdgeComputing","Technology",true),
      new topics("EDTech","Technology",true),new topics("Fastly","Technology",true),
      new topics("Fintech","Technology",true),new topics("FullStack","Technology",true),
      new topics("FutureOfWork","Technology",true),new topics("Gartner","Technology",true),
      new topics("GraphDb","Disruptive Innovation",true),new topics("GCP","Disruptive Innovation",true),
      new topics("HealthTech","Technology",true),new topics("Kubernetes","Technology",true)];

  this.sourceTopics2=[  
      new topics("MachineLearning","Technology",true),new topics("MicroService","Technology",true),
      new topics("MultiCloud","Technology",true),new topics("Neo4J","Technology",true),
      new topics("OpenShift","Technology",true),new topics("Programming","Technology",true),
      new topics("QuantumComputing","Disruptive Innovation",true),new topics("ReactJs","Disruptive Innovation",true),
      new topics("RegTech","Disruptive Innovation",true),new topics("Remote Collaboration","Disruptive Innovation",true),
      new topics("SpringBoot","Technology",true),new topics("ServiceNow","Technology",true),
      new topics("SnowFlake","Disruptive Innovation",true),new topics("SRE","Disruptive Innovation",true),
     new topics("TeleMedicine","Disruptive Innovation",true),new topics("YellowBrick","Disruptive Innovation",true),
     new topics("WealthTech","Disruptive Innovation",true)
    ];

  }

  ngOnInit(): void {
  }

}
