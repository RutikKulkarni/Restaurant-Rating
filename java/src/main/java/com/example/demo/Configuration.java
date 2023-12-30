package com.example.demo;

import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.CreateRatingCommand;
import com.example.demo.commands.CreateRestaurantCommand;
import com.example.demo.commands.CreateReviewCommand;
import com.example.demo.commands.CreateUserCommand;
import com.example.demo.commands.DescribeRestoCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.GetReviewCommand;
import com.example.demo.commands.GetReviewsFilter;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListRestoCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IRestaurantRepo;
import com.example.demo.repositories.IReviewRepo;
import com.example.demo.repositories.IUserRepo;
import com.example.demo.repositories.RestaurantRepo;
import com.example.demo.repositories.ReviewRepo;
import com.example.demo.repositories.UserRepo;
import com.example.demo.services.GreetingService;
import com.example.demo.services.RestaurantService;
import com.example.demo.services.ReviewService;
import com.example.demo.services.UserService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final IUserRepo userRepository = new UserRepo();
            private final IRestaurantRepo restaurantRepo = new RestaurantRepo();
            private final IReviewRepo reviewRepo = new ReviewRepo();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final UserService userService = new UserService(userRepository);
            private final RestaurantService restaurantService = new RestaurantService(restaurantRepo);
            private final ReviewService reviewService = new ReviewService(reviewRepo);

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private final CreateUserCommand createUserCommand = new CreateUserCommand(userService);
            private final CreateRestaurantCommand createRestaurantCommand = new CreateRestaurantCommand(restaurantService);
            private final CreateReviewCommand createReviewCommand = new CreateReviewCommand(reviewService,restaurantService);
            private final CreateRatingCommand createRatingCommand = new CreateRatingCommand(reviewService,restaurantService);
            private final GetReviewCommand getReviewCommand = new GetReviewCommand(reviewService);
            private final GetReviewsFilter getReviewsFilter = new GetReviewsFilter(reviewService);
            private final DescribeRestoCommand describeRestoCommand = new DescribeRestoCommand(restaurantService);
            private final ListRestoCommand listRestoCommand = new ListRestoCommand(restaurantService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);
                // To create the user
                commandRegistry.registerCommand(CommandKeyword.REGISTER_USER_COMMAND.getName(),createUserCommand);
                // To create Resto
                commandRegistry.registerCommand(CommandKeyword.REGISTER_RESTAURANT_COMMAND.getName(),createRestaurantCommand);
                // To create_review 
                commandRegistry.registerCommand(CommandKeyword.ADD_REVIEW.getName(),createReviewCommand);
                // To create the rating comand
                commandRegistry.registerCommand(CommandKeyword.ADD_RATING.getName(),createRatingCommand);
                // get the review
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS.getName(),getReviewCommand);
                // Filter the reviews
                commandRegistry.registerCommand(CommandKeyword.GET_REVIEWS_FILTER_ORDER.getName(),getReviewsFilter);
                // Description of the resto
                commandRegistry.registerCommand(CommandKeyword.DESCRIBE_RESTAURANT.getName(),describeRestoCommand);
                // List alll the restor
                commandRegistry.registerCommand(CommandKeyword.LIST_RESTAURANTS.getName(),listRestoCommand);
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
