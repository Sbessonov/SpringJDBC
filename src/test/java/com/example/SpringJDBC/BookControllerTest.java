package com.example.SpringJDBC;

//@WebMvcTest(BookController.class)
//@RequiredArgsConstructor
//public class BookControllerTest {
//
//
//    private final MockMvc mockMvc;
//
//
//    @Test
//    public void creteBook() throws Exception {
//        Book book = new Book(1L, "Book1", "Author1", LocalDateTime.now());
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(book);
//
//
//        mockMvc.perform(post("api/books/post")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonString))
//                .andExpect(status().isCreated());
//    }
//}
