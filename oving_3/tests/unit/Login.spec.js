import { mount } from "@vue/test-utils";
import LoginComponent from "@/components/LoginComponent.vue";
import store from "@/store";
import router from "@/router";

describe("LoginComponent.vue", () => {
  test("Check that Login message renders", () => {
    const loginTitle = "Please login!";
    const wrapper = mount(LoginComponent, {
      global: {
        plugins: [store, router],
      },
    });
    const loginMessage = wrapper.find("[data-testid='loginLabel']");
    expect(loginMessage.text()).toMatch(loginTitle);
  });

  test("Check that the rest of the elements render", async () => {
    const wrapper = mount(LoginComponent, {
      global: {
        plugins: [store, router],
      },
    });
    expect(wrapper.find("#loginStatusLabel").exists()).toBe(true);
    const statusId = wrapper.find("#loginStatusLabel");

    expect(statusId.element.id).toBe("loginStatusLabel");

    expect(statusId.element.textContent).toBe("");
  });

  test("Modified LoginComponent data renders properly", async () => {
    const wrapper = mount(LoginComponent, {
      global: {
        plugins: [store, router],
      },
    });
    const statusId = wrapper.find("#loginStatusLabel");

    await store.dispatch("updateLoginStatus", "Success");
    expect(statusId.element.textContent).toBe("Success");
    await store.dispatch("updateLoginStatus", "Failed");
    expect(statusId.element.textContent).toBe("Failed");

    await store.dispatch("updateLoginStatus", "");
  });

  test("Check that input is working", async () => {
    const wrapper = mount(LoginComponent, {
      global: {
        plugins: [store, router],
      },
    });
    const username = "user";
    const password = "pass";
    const usernameInput = wrapper.find("#usernameInput");
    const passwordInput = wrapper.find("#passwordInput");

    await usernameInput.setValue("user");
    await passwordInput.setValue("pass");

    expect(usernameInput.element.value).toEqual(username);
    expect(passwordInput.element.value).toEqual(password);
  });

  test("Sign in button is clicked and calls handelClickSignin()", async () => {
    const wrapper = mount(LoginComponent, {
      global: {
        plugins: [store, router],
      },
    });
    const button = wrapper.find("#signInButton");
    const registerMessage = wrapper.find("#buttonPressed");

    await button.trigger("click");

    expect(registerMessage.isVisible()).toBe(true);
  });

  test("Register option renders when login fails", async () => {
    const wrapper = mount(LoginComponent, {
      global: {
        plugins: [store, router],
      },
    });
    const registerContainer = wrapper.find("[data-testid='registerContainer']");
    await wrapper.setData({ loginSuccess: false });

    expect(registerContainer.isVisible()).toBe(true);
  });

  test("Register option does not render initially", async () => {
    const wrapper = mount(LoginComponent, {
      global: {
        plugins: [store, router],
      },
    });
    const registerContainer = wrapper.find("[data-testid='registerContainer']");
    await wrapper.setData({ loginSuccess: true });

    expect(registerContainer.isVisible()).toBe(false);
  });
});
