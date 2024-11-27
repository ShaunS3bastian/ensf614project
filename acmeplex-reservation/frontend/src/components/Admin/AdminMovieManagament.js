import React, { useState, useEffect } from "react";
import axios from "axios";

const ManageMovies = () => {
    const [movies, setMovies] = useState([]);
    const [newMovie, setNewMovie] = useState({ title: "", genre: "", description: "", duration: 0 });

    useEffect(() => {
        const fetchMovies = async () => {
            const response = await axios.get("http://localhost:8080/api/admin/movies");
            setMovies(response.data);
        };
        fetchMovies();
    }, []);

    const addMovie = async () => {
        const response = await axios.post("http://localhost:8080/api/admin/movies", newMovie);
        setMovies([...movies, response.data]);
    };

    const deleteMovie = async (id) => {
        await axios.delete(`http://localhost:8080/api/admin/movies/${id}`);
        setMovies(movies.filter((movie) => movie.id !== id));
    };

    return (
        <div>
            <h3>Manage Movies</h3>
            <div>
                <input
                    type="text"
                    placeholder="Title"
                    value={newMovie.title}
                    onChange={(e) => setNewMovie({ ...newMovie, title: e.target.value })}
                />
                <button onClick={addMovie}>Add Movie</button>
            </div>
            <ul>
                {movies.map((movie) => (
                    <li key={movie.id}>
                        {movie.title} <button onClick={() => deleteMovie(movie.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ManageMovies;
