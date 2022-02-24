import { doLogin } from "@/utils/apiutils";
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
});
