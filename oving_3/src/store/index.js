import { createStore } from "vuex";

export default createStore({
  state: {
    reviews: [],
  },
  mutations: {
    ADD_REVIEW(state, review) {
      state.reviews.push(review);
    },
  },
  actions: {
    createReview({ commit }, review) {
      commit("ADD_REVIEW", review);
    },
  },
  modules: {},
});
