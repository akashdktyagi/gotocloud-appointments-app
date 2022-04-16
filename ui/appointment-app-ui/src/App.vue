<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>

<div id="app">
  <h1>Demo Appointment Booking App</h1>
  <h4>Purpose: Cloud Native Architecture Demonstration</h4>
  <p><b>Author:</b> Akash Tyagi. Reach out at: akashdktyagi@gmail.com</p>
  <menu>
    <nav>
        <ul>
            <li><RouterLink to="/">Home</RouterLink></li>
            <li><RouterLink to="/doctors">Doctors Info</RouterLink></li>
            <li><RouterLink to="/pageIsNotReadyYet">Patients Info</RouterLink></li>
            <li><RouterLink to="/pageIsNotReadyYet">Appointment Booking</RouterLink></li>
        </ul>
    </nav>
  </menu>
  
  <RouterView></RouterView>
</div>

</template>

<style>

h1,h4,p {
    text-align: center;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: rgb(221, 19, 19);
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 50px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
