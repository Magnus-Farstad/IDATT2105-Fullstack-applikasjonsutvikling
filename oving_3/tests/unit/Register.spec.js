import { mount } from "@vue/test-utils";
import RegisterComponent from "@/components/RegisterComponent.vue";
import router from "@/router";

describe("Tests for RegisterComponent.vue", () => {
  test("Check that all elements render", async () => {
    const wrapper = mount(RegisterComponent, {
      global: {
        plugins: [router],
      },
    });

    const registerTitle = "Register!";
    const registerMessage = wrapper.find(".registerMessage");
    expect(registerMessage.text()).toEqual(registerTitle);

    const registerContainer = wrapper.find(".registerContainer");
    expect(registerContainer.exists()).toBe(true);
  });

  test("Check that register button is disabled when form is not filled out", async () => {
    const wrapper = mount(RegisterComponent, {
      global: {
        plugins: [router],
      },
    });
    const registerButton = wrapper.find("#registerbutton");
    expect(registerButton.exists()).toBe(true);
    expect(registerButton.element.disabled).toBe(true);
  });

  test("Check that input is correct", async () => {
    const wrapper = mount(RegisterComponent, {
      global: {
        plugins: [router],
      },
    });
    const name = "Magnus";

    const nameInput = wrapper.find("#name");
    nameInput.setValue("Magnus");

    expect(nameInput.element.value).toEqual(name);
  });
});
