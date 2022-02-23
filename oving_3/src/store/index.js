import { createStore } from "vuex";

export default createStore({
  state: {
    reviews: [],
    status: "",
    flashMessage: "",
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
  },
  modules: {},
});
