import { doLogin } from "@/utils/apiutils";

describe("testing apiutils.vue", () => {
  test("test API call utility function - login Success", async () => {
    const loginRequest = { username: "user", password: "pass" };
    const loginResponse = await doLogin(loginRequest);
    const expectedLoginRespone = { loginStatus: "Success" };
    expect(loginResponse).toEqual(expectedLoginRespone);
  });

  test("test API call utility function - login Fail", async () => {
    const loginRequest = { username: "userx", password: "passx" };
    const loginResponse = await doLogin(loginRequest);
    const expectedLoginResponse = { loginStatus: "Fail" };
    expect(loginResponse).toEqual(expectedLoginResponse);
  });
});
