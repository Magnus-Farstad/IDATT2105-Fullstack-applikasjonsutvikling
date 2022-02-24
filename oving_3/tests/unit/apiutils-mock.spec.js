import {doLogin, doRegistration} from "@/utils/apiutils";
import axios from "axios";

jest.mock("axios");

describe("testing mocking of apiutils.vue", () => {
  it("check that login is successful - against mock", async () => {
    // mock api response on POST call (once)
    const expectedLoginResponse = { loginStatus: "Success" };
    axios.post.mockImplementation(() =>
      Promise.resolve({ data: expectedLoginResponse })
    );

    // do the call
    const loginRequest = { username: "user1", password: "pass1" };
    const loginResponse = await doLogin(loginRequest);

    //  check response
    //  note that even if wrong username and password are used, mock is configured to return Success
    expect(loginResponse).toEqual(expectedLoginResponse);
  });

  test("Check that registration was successful - against mock", async () => {
    // mock api response on POST call (once)
    const expectedRegistrationResponse = { registrationStatus: "Success" };
    axios.post.mockImplementation(() =>
      Promise.resolve({ data: expectedRegistrationResponse })
    );

    // do the call
    const registrationRequest = {
      name: "Magnus Farstad",
      address: "tullegata 1",
      username: "magnus123",
      password: "password",
      email: "magnus@ntnu.no",
      phone: "000987654",
    };
    const registrationResponse = await doRegistration(registrationRequest);

    //  check response
    //  note that even if wrong username and password are used, mock is configured to return Success
    expect(registrationResponse).toEqual(expectedRegistrationResponse);
  });
});
