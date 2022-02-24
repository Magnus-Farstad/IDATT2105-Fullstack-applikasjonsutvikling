import { mount, shallowMount } from "@vue/test-utils";
import LoginComponent from "@/components/LoginComponent.vue";

describe("LoginComponent.vue", () => {
  test("Check that Login message renders", () => {
    const loginTitle = "Please login!";
    const wrapper = mount(LoginComponent);
    const loginMessage = wrapper.find("[data-testid='loginLabel']");
    expect(loginMessage.text()).toMatch(loginTitle);
  });

  test("Check that the rest of the elements render", async () => {
    const wrapper = shallowMount(LoginComponent);

    // add some additional checks. For example related to loginStatusLabel element
    // check that loginstatusLabel component exists
    expect(wrapper.find("#loginStatusLabel").exists()).toBe(true);
    const statusId = wrapper.find("#loginStatusLabel");
    // check that id of the loginstatusLabel element is correct
    expect(statusId.element.id).toBe("loginStatusLabel");
    // check that the loginstatusLabel element is displaying correct value
    expect(statusId.element.textContent).toBe("");
  });

  test("Modified LoginComponent data renders properly", async () => {
    const wrapper = shallowMount(LoginComponent);

    // get loginstatusLabel element
    const statusId = wrapper.find("#loginStatusLabel");
    // change loginStatus data and check that loginstatusLabel element is updated accordingly

    await wrapper.setData({ loginstatus: "Success" });
    expect(statusId.element.textContent).toBe("Success");
    await wrapper.setData({ loginstatus: "Failed" });
    expect(statusId.element.textContent).toBe("Failed");
  });
});
