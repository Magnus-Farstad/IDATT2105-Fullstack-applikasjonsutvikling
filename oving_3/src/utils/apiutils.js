import axios from "axios";

export function doLogin(loginRequest) {
  return axios
    .post(`http://localhost:8085/login`, loginRequest)
    .then((response) => {
      return response.data;
    });
}

export function doRegistration(registrationRequest) {
  return axios
    .post("http://localhost:3000/", registrationRequest)
    .then((response) => {
      return response.data;
    });
}

export function doCalculation(calculation) {
  return axios
    .post("http://localhost:8085/calculator", calculation)
    .then((response) => {
      return response.data;
    });
}
