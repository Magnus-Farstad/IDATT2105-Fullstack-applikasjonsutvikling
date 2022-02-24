import { createStore } from "vuex";

export default createStore({
  state: {
    reviews: [],
    status: "",
    flashMessage: "",
    loginStatus: "",
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
  },
  getters: {
    getLoginStatus(state) {
      return state.loginStatus;
    }
  },
  modules: {},
});
