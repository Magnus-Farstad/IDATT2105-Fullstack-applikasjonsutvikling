import { createStore } from "vuex";

export default createStore({
  state: {
    reviews: [],
    status: "",
    flashMessage: "",
    loginStatus: "",
    jwtToken: null,
    userLoggedIn: false,
    currentUser: {
      user_id: null,
      username: null,
      name: null,
    },
  },
  mutations: {
    ADD_REVIEW(state, review) {
      state.reviews.push(review);
    },
    SET_STATUS(state, status) {
      state.status = status;
    },
    SET_FLASHMESSAGE(state, message) {
      state.flashMessage = message;
    },
    SET_LOGINSTATUS(state, loginstatus) {
      state.loginStatus = loginstatus;
      console.log("From inside store " + state.loginStatus);
    },
    SET_CURRENT_USER(state, loginresponse) {
      state.currentUser.userId = loginresponse.user_id;
      state.currentUser.userName = loginresponse.username;
      state.currentUser.name = loginresponse.name;
      state.userLoggedIn = true;
    },
    REMOVE_USER(state) {
      state.currentUser.userId = null;
      state.currentUser.user_id = null;
      state.currentUser.userName = null;
      state.currentUser.username = null;
      state.currentUser.name = null;
      state.userLoggedIn = false;
      state.loginStatus = "";
      state.jwtToken = null;
    },
    SET_TOKEN(state, token) {
      state.jwtToken = token;
    },
    RESTORE_USER(state) {
      const tokenString = localStorage.getItem("token");
      const userString = localStorage.getItem("user");
      if (tokenString && userString) {
        state.userLoggedIn = true;
        state.jwtToken = JSON.parse(tokenString);
        const currentUser = JSON.parse(userString);
        state.currentUser = currentUser;
        state.loginStatus = currentUser.loginStatus;
      }
    },
  },
  actions: {
    createReview({ commit }, review) {
      commit("ADD_REVIEW", review);
    },
    updateStatus({ commit }, status) {
      commit("SET_STATUS", status);
    },
    updateFlashMessage({ commit }, message) {
      commit("SET_FLASHMESSAGE", message);
    },
    updateLoginStatus({ commit }, loginstatus) {
      commit("SET_LOGINSTATUS", loginstatus);
    },
    updateCurrentUser({ commit }, loginresponse) {
      commit("SET_CURRENT_USER", loginresponse);
      localStorage.setItem("user", JSON.stringify(loginresponse));
    },
    logOutUser({ commit }) {
      commit("REMOVE_USER");
      localStorage.removeItem("user");
      localStorage.removeItem("token");
    },
    addJwtToken({ commit }, token) {
      commit("SET_TOKEN", token);
      localStorage.setItem("token", JSON.stringify(token));
    },
  },
  getters: {
    getLoginStatus(state) {
      return state.loginStatus;
    },
  },
  modules: {},
});
