
<script>

import axios from 'axios';

export default {
  props: {
    msg: String
  },
  data(){
    return {
      apiURL: import.meta.env.VITE_API_URL,
      doctorsInfo: '',
      errorMessage: '',
      id: '',
      name: '',
      registrationID: '',
      specialization: '',
      qualifications:'',
      experienceInYears: '',
      emailID: '',
      clinicNameAndAddress: '',
      canDoHomeVisit: ''
    }
  },
  methods: {
// 'http://localhost:9000/api/doctors'
    getListOfAllDoctors(){
      // const BASE_URL = process.env.VUE_APP_BASEURL
      console.log("API URL: " + this.apiURL);
      axios
      .get(this.apiURL + "/doctors") 
            // .get("http://localhost:9000/api/doctors") 
      .then(
        res=>{
          this.doctorsInfo = res.data;
          console.log("Status for get Request: " + res.status);
        }
      ).catch(function (error) {
          if (error.response) {
            // Request made and server responded
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);
            this.errorMessage = "Data:" + error.response.data + " Status: " + error.response.status + "Headers: " + error.response.headers;
          } else if (error.request) {
            // The request was made but no response was received
            console.log(error.request);
            this.errorMessage = error.request;
          } else {
            // Something happened in setting up the request that triggered an Error
            console.log('Error', error.message);
            this.errorMessage = error.message;
          }

          });
    }
  },
  components:{

  },
  emits: [],
  computed: {

  }
}

</script>

<template>
  <div class="greetings">
    <h1 class="green">List of All Doctors</h1>
    <button class="button button2" @click="getListOfAllDoctors()">Get List of Doctors</button>
  </div>

  <div>
    <table v-if="doctorsInfo">
      <tr>
        <th>id</th>
        <th>name</th>
        <th>registrationID</th>
        <th>specialization</th>
        <th>qualifications</th>
        <th>experienceInYears</th>
        <th>emailID</th>
        <th>clinicNameAndAddress</th>
        <th>canDoHomeVisit</th>
      </tr>
      <tr v-for="doc in doctorsInfo">
          <td>{{doc.id}}</td>
          <td>{{doc.name}}</td>
          <td>{{doc.registrationID}}</td>
          <td>{{doc.specialization}}</td>
          <td>{{doc.qualifications}}</td>
          <td>{{doc.experienceInYears}}</td>
          <td>{{doc.emailID}}</td>       
          <td>{{doc.clinicNameAndAddress}}</td>       
          <td>{{doc.canDoHomeVisit}}</td>                                          
      </tr>
    </table>
  </div>
    <hr>
    <h2>Debug Point. Doctor's API response: </h2>
    <div> {{doctorsInfo}}</div>
    <hr>
    <div>errors : {{errorMessage}}</div>

</template>

<style scoped>
h1 {
  font-weight: 500;
  font-size: 2.6rem;
  top: -10px;
}

h3 {
  font-size: 1.2rem;
}

div {
  text-align: center;
}

.greetings h3 {
  text-align: center;
}

.button {
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button1 {background-color: #4CAF50;} /* Green */
.button2 {background-color: #008CBA;} /* Blue */

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

/* .greetings h1,


@media (min-width: 1024px) {
  .greetings h1,
  .greetings h3 {
    text-align: left;
  } 
}*/
</style>
