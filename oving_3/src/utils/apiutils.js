import axios from "axios";

export function doLogin(loginRequest, token) {
  return axios
    .post(`http://localhost:8085/login`, loginRequest, {
      headers: {
        Authorization: "Bearer " + token,
      },
    })
    .then((response) => {
      return response.data;
    });
}

export function doRegistration(registrationRequest, token) {
  return axios
    .post("http://localhost:8085/register", registrationRequest, {
      headers: {
        Authorization: "Bearer " + token,
      },
    })
    .then((response) => {
      return response.data;
    });
}

export function doCalculation(calculation, id, token) {
  return axios
    .post("http://localhost:8085/calculator/" + id, calculation, {
      headers: {
        Authorization: "Bearer " + token,
      },
    })
    .then((response) => {
      return response.data;
    });
}

export function getAllCalculations(id, token) {
  return axios
    .post("http://localhost:8085/calculator/calculations/" + id, null, {
      headers: {
        Authorization: "Bearer " + token,
      },
    })
    .then((response) => {
      return response.data;
    });
}

export function getJwtToken(username, password) {
  return axios
    .post(
      "http://localhost:8085/token?username=" +
        username +
        "&password=" +
        password
    )
    .then((response) => {
      return response.data;
    });
}

export function deleteCalculation(id, token) {
  return axios
    .delete("http://localhost:8085/calculator/delete/" + id, {
      headers: {
        Authorization: "Bearer " + token,
      },
    })
    .then((response) => {
      return response.data;
    });
}
