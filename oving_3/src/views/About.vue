<template>
  <div class="container">
    <div class="aboutMe">
      <h1>Who am I?</h1>
      <p>
        I am a student at NTNU, Trondheim Norway. Currently I am in my second
        year of my Bachelor of Engineering in Computer Science.
      </p>
    </div>
    <div class="aboutProject">
      <h1>What is this project?</h1>
      <p>
        This is part of the mandatory assignments in the course Full-stack
        application development. It was originally created to be assignment no.
        3, but was later revised multiple times. Now it serves as the frontend
        client for all the assignments, being multiple backend project.
      </p>
    </div>
  </div>
</template>
<style scoped>
div {
  background: white;
  border-radius: 10px;
  box-shadow: 0 3px 6px #262626;
  max-width: 22rem;
  padding: 1rem;
}
p {
  max-width: 20rem;
  margin: 0 auto 2rem auto;
  line-height: 1.5;
}

.container {
  background: none;
  box-shadow: none;
  margin: 0 auto;
}
.aboutProject {
  margin-top: 3rem;
}
</style>
