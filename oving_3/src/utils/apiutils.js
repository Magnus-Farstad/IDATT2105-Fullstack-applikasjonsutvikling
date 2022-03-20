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
    .post("http://localhost:8085/register", registrationRequest)
    .then((response) => {
      return response.data;
    });
}

export function doCalculation(calculation, id) {
  return axios
    .post("http://localhost:8085/calculator/" + id, calculation)
    .then((response) => {
      return response.data;
    });
}

export function getAllCalculations(id) {
  return axios
    .post("http://localhost:8085/calculator/calculations/" + id)
    .then((response) => {
      return response.data;
    });
}
