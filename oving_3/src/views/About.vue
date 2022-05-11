<template>
  <div class="container">
    <div
      @click="toggleColor"
      :class="{ containerAlternative: colorClass }"
      class="aboutMe box"
    >
      <h1>Who am I?</h1>
      <p>
        I am a student at NTNU, Trondheim Norway. Currently I am in my second
        year of my Bachelor of Engineering in Computer Science.
      </p>
    </div>
    <div
      @click="toggleColor"
      :class="{ containerAlternative: colorClass }"
      class="aboutProject box"
    >
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
<script>
export default {
  data() {
    return {
      colorClass: false,
    };
  },
  methods: {
    toggleColor() {
      this.colorClass = !this.colorClass;
    },
  },
};
</script>
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

@keyframes rotate-hue {
  100% {
    filter: hue-rotate(360deg);
  }
  50% {
    filter: hue-rotate(600deg);
  }
}

.box {
  transition: 0.2s ease-in-out;
}
.box:hover {
  transform: translateY(-4px);
  cursor: pointer;
}
.container {
  color: black;
  background: none;
  box-shadow: none;
  margin: 0 auto;
}
.containerAlternative {
  animation: rotate-hue 5s alternate infinite;
  background: lightblue;
}
.aboutProject {
  margin: 3rem 0 0 0;
}
</style>
