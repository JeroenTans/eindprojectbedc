package com.example.eindprojectbedc.Controller;

import com.example.eindprojectbedc.ServiceTest.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class GroupControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    GroupService groupService;

//    @Test
//    public void giveGroup_whenGetWholeGroup_thenReturnJsonArray() throws Exception {
//        Group group = new Group();
//        group.setId(1L);
//        group.setEmailAddress("jan@");
//        List<Group> groupList = Arrays.asList(group);
//        given(groupService.getWholeGroup()).hasSize(groupList.size());
//
//        mvc.perform(get("/api/v1/group")
//                                    .contentType(MediaType.APPLICATION_JSON))
//                                    .andExpect(status().isOk())
//                                    .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
//                                    .andExpect((ResultMatcher) jsonPath("$[0].emailAddress", is(group.getEmailAddress())));
//    }


}
